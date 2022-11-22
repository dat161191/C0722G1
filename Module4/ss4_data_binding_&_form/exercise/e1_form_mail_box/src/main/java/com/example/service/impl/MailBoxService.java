package com.example.service.impl;

import com.example.model.Mailbox;
import com.example.service.IMailBoxService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailBoxService implements IMailBoxService {
    private static List<Mailbox> mailboxList;

    static {
        mailboxList = new ArrayList<>();
        mailboxList.add(new Mailbox(1, "English", 5, true, "Thor"));
        mailboxList.add(new Mailbox(3, "Vietnamese", 10, false, "Thánh Gióng"));
        mailboxList.add(new Mailbox(5, "Japanese", 5, true, "ZoRo"));
        mailboxList.add(new Mailbox(7, "Japanese", 5, true, "Mihaw"));
    }

    @Override
    public List<Mailbox> fileAll() {
        return mailboxList;
    }

    @Override
    public void update(Mailbox mailbox) {
        Mailbox mailbox1 = findById(mailbox.getId());
        mailbox1.setLanguages(mailbox.getLanguages());
        mailbox1.setPageSize(mailbox.getPageSize());
        mailbox1.setSpamsFilter(mailbox.isSpamsFilter());
        mailbox1.setSignature(mailbox.getSignature());
    }

    @Override
    public Mailbox findById(int id) {
        for (Mailbox mailBox: mailboxList) {
            if (mailBox.getId()==id){
                return mailBox;
            }
        }
        return null;
    }
}
