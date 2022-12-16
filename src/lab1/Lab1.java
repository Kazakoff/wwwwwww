/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import entity.Gruppyi;
import entity.Studentyi;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.NewHibernateUtil;

/**
 *
 * @author 17682
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sf =  NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();
      Transaction transaction = s.beginTransaction();
   /*   Studentyi d = new Studentyi( nomerZachetki, gruppyi, familiya, imya, otchestvo, gorod,  adres,  tel,  status, statusDate);
    s.persist(d);
 //   s.save(d);
*/
transaction.commit();
        
        List <Studentyi> q = s.createQuery("from Studentyi s").list();
      Transaction t = s.beginTransaction();       
      for (Studentyi u : q)
     {
          System.out.print(u.getImya());
          u.setImya(new String());
          s.update(u);
     } 
s.flush();
t.commit();
        s.close();
        // TODO code application logic here
    }
    
}
