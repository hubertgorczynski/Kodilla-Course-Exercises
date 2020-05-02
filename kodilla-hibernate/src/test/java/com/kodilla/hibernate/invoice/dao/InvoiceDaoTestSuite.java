package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Invoice invoice = new Invoice("2019/05/01");

        Product bike = new Product("bike");
        Product ball = new Product("ball");
        Product towel = new Product("towel");

        Item itemBike = new Item(bike, new BigDecimal(500), 1);
        Item itemBall = new Item(ball, new BigDecimal(45), 2);
        Item itemTowel = new Item(towel, new BigDecimal(3), 5);

        itemBike.setInvoice(invoice);
        itemBall.setInvoice(invoice);
        itemTowel.setInvoice(invoice);

        List<Item> items = new ArrayList<>();
        items.add(itemBike);
        items.add(itemBall);
        items.add(itemTowel);

        invoice.setItems(items);

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();
        int itemSize = invoice.getItems().size();

        Invoice invoiceReadFromDB = invoiceDao.findById(invoiceId);

        //Then
        Assert.assertEquals(invoiceId, invoiceReadFromDB.getId());
        Assert.assertEquals(3, itemSize);

        //CleanUp
        invoiceDao.deleteById(invoiceId);
    }
}