import javax.persistence.EntityTransaction;

/**
 * It has one-to-one relationship with EntityManager. For each EntityManager, operations are maintained by EntityTransaction class.
 */
public class MyEntityTransaction implements EntityTransaction {
    @Override
    public void begin() {

    }

    @Override
    public void commit() {

    }

    @Override
    public void rollback() {

    }

    @Override
    public void setRollbackOnly() {

    }

    @Override
    public boolean getRollbackOnly() {
        return false;
    }

    @Override
    public boolean isActive() {
        return false;
    }
}
