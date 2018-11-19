package br.com.projetojsf.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;



public class HibernateUtil {
         
	  private static StandardServiceRegistry registry;
	  private static SessionFactory sessionFactory;
	  public static final String HIBERNATE_SESSION = "hibernate_session";
	  
	  
        public static SessionFactory getSessionFactory() {
            if (sessionFactory == null) {
              try {
                // Create registry
                registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();

              } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                  StandardServiceRegistryBuilder.destroy(registry);
                }
              }
            }
            return sessionFactory;
          }

          public static void shutdown() {
            if (registry != null) {
              StandardServiceRegistryBuilder.destroy(registry);
            }
          }
	
	
}
