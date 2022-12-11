package org.example.DataBaseConnection;

import lombok.NoArgsConstructor;
import lombok.var;
import org.example.entity.Daneshjo;
import org.example.entity.Loans;
import org.example.entity.Paid;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@NoArgsConstructor
public class SingleTonConnection {
    private static class LazyHolder{
        static SessionFactory INSTANCE;

        static {
            var registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

            INSTANCE = new MetadataSources(registry)
                    .addAnnotatedClass(Daneshjo.class)
                    .addAnnotatedClass(Loans.class)
                    .addAnnotatedClass(Paid.class)
                    .buildMetadata()
                    .buildSessionFactory();
        }
    }
    public static SessionFactory getInstance(){
        return LazyHolder.INSTANCE;
    }
}
