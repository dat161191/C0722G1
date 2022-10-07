package case_study_module2.service.impl_contracts;

import case_study_module2.model.Contract.Contract;
import case_study_module2.service.IContractsService;

import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ContractsService implements IContractsService {
    private static Queue<Contract> contracts = new PriorityQueue<>();

    @Override
    public void createNewContracts() {

    }

    @Override
    public void displayListContracts() {

    }

    @Override
    public void editContracts() {

    }
}
