package com.projektcwiczeniowy.Shop;

import com.projektcwiczeniowy.Shop.model.Item;
import com.projektcwiczeniowy.Shop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DbInitalizer implements CommandLineRunner {

    private final ItemRepository itemRepository;

    @Autowired
    public DbInitalizer(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        itemRepository.saveAll(List.of(
                new Item("Bluza", new BigDecimal("200"),"https://mastersport-pl.assets-nc.link/product_picture/6/NME3A8/NME3A8_bluza-nike-park20-zip-up-hoodie-s-czarny.png"),
                new Item("Spodnie", new BigDecimal("170"),"https://cdn.sport-shop.pl/p/v1/medium/72f0c7c870518ce11b93606b1772793e.jpg"),
                new Item("Buty", new BigDecimal("300"),"https://antyradio-static.hitraff.pl/uploads/productfeeds/images/9f/a8/nike-buty-meskie-sportowe-nike-mc-trainer-2.jpg"),
                new Item("Pilka", new BigDecimal("90"),"https://dekoracjetortowe.pl/1301-medium_default/nadruk-jadalny-pilka-nozna-nike-fc-barcelona-02.jpg"),
                new Item("Koszulka", new BigDecimal("150"),"https://thumblr.uniid.it/product/246585/6083d07d57c6.jpg"),
                new Item("Plecak", new BigDecimal("120"),"https://butysportowe.pl/media/cache/gallery/rc/j8rqyiqr/nike-plecak-team-training-max-air-lar-unisex-plecaki-ba4595067.jpg")
        ));
    }
}
