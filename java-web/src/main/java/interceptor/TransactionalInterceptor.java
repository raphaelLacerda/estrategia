package interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor
@Transactional
public class TransactionalInterceptor {

	@Inject
	private EntityManager entityManager;

	@AroundInvoke
	public Object intercept(InvocationContext ic) {

		entityManager.getTransaction().begin();

		Object retorno = null;
		try {
			retorno = ic.proceed();
		} catch (Exception e) {

			entityManager.getTransaction().rollback();
			throw new IllegalStateException(e);
		}

		entityManager.getTransaction().commit();

		return retorno;
	}

}
