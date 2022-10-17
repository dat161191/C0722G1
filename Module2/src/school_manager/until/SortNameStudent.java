package school_manager.until;

import school_manager.model.AccountBank;

import java.util.Comparator;

public class SortNameStudent implements Comparator<AccountBank> {
    @Override
    public int compare(AccountBank o1, AccountBank o2) {
        if (o1.getName().compareTo(o2.getName()) != 0) {
            return o1.getName().compareTo(o2.getName());
        } else {
            return o1.getCode().compareTo(o2.getCode());
        }
    }
}
