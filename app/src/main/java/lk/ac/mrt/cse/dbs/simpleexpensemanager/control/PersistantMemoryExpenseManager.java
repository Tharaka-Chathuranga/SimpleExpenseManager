package lk.ac.mrt.cse.dbs.simpleexpensemanager.control;

import android.content.Context;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.TransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistantMemoryTransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistantmemoryAccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Account;

public class PersistantMemoryExpenseManager extends ExpenseManager {
    private Context context;
    public PersistantMemoryExpenseManager(Context context) {
        this.context=context;
        setup();
    }

    @Override
    public void setup() {
        /*** Begin generating dummy data for In-Memory implementation ***/
        TransactionDAO x = new PersistantMemoryTransactionDAO(context);


        AccountDAO persistantmemoryAccountDAO = new PersistantmemoryAccountDAO(context);
        setAccountsDAO(persistantmemoryAccountDAO);
        setTransactionsDAO(x);



        /*** End ***/
    }
}
