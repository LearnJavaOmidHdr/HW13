package org.example.repository;

import org.example.DataBaseConnection.SingleTonConnection;
import org.example.entity.Loans;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Optional;

public class LoanRepository extends RepositoryImpl<Loans, Long> {

    public static boolean checkLoanExists(long id, String type) {
        final LoanRepository loanRepository = new LoanRepository();
        Transaction transaction = null;
        try {
            Session session = SingleTonConnection.getInstance().openSession();
            transaction = session.beginTransaction();
            final NativeQuery nativeQuery = session.createNativeQuery("select typeloan from loans where daneshjo_id = ? and typeloan = ?;");
            nativeQuery.setParameter(1, id);
            nativeQuery.setParameter(2, type);
            final Optional first = nativeQuery.getResultList().stream().findFirst();
            return first.isPresent();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static List<Loans> daneshjoLoans(Long id) {
        Session session = SingleTonConnection.getInstance().openSession();
        try {
            Query q = session.createQuery("select l from Loans l where l.daneshjo.id = :id");
            q.setParameter("id", id);
            List<Loans> list = q.list();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }finally {
            session.close();
        }
    }

}
