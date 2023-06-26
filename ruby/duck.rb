
   class Pato

     def quack

       'Quack!'

     end

 

     def nadar

       'nadando nadando nadando...'

     end

   end


 


   class Ganso


     def grasnar


       'Grasnando!'


     end


 


     def nadar


       'Splash splash splash...'


     end


   end


 


   class PatoDonald


     def quack


       play


     end


 


     def play


       'Quack! Sou o Pato Donald!'


     end


   end


 


   def faz_quack(pato)

    if pato.respond_to? "quack"
        pato.quack
    else   
        "NAO FAZ QUACK"
    end

   end


puts faz_quack(Pato.new)
g = Ganso.new
puts faz_quack(g)
puts faz_quack(PatoDonald.new)

def g.quack
    "ganso agora faz quack"
end
puts faz_quack(g)

   def faz_nadar(duck)


     duck.nadar


   end


   puts faz_nadar(Pato.new)
   puts faz_nadar(Ganso.new)