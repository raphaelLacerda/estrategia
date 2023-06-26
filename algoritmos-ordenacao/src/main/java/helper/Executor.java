package helper;

import algoritmos.Habilitado;
import algoritmos.Ordenador;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.Set;

public class Executor {

    private final boolean impressaoHabilitada;

    public Executor(boolean impressaoHabilitada) {
        this.impressaoHabilitada = impressaoHabilitada;
    }

    public void executarTodosAlgoritmos(int[] array) {

        Set<Class<?>> classes = recuperarTodasClassesDeAlgoritmosHabilitadas();


        classes.stream().sorted(Comparator.comparing(Class::getName)).forEach(clazz -> {
            try {
                Ordenador ordenador = (Ordenador) clazz.getConstructor(boolean.class).newInstance(this.impressaoHabilitada);
                ordenador.ordenar(array.clone());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        });
    }

    private Set<Class<?>> recuperarTodasClassesDeAlgoritmosHabilitadas() {
        Reflections reflections = new Reflections(
                new ConfigurationBuilder()
                        .setUrls(ClasspathHelper.forJavaClassPath())
        );
        return reflections.getTypesAnnotatedWith(Habilitado.class);
    }

}
