package com.projektcwiczeniowy.Shop.controller;

import com.projektcwiczeniowy.Shop.Cart;
import com.projektcwiczeniowy.Shop.model.Item;
import com.projektcwiczeniowy.Shop.repository.ItemRepository;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class HomeController {

    private final ItemRepository itemRepository;

    private final Cart cart;

    @Autowired
    public HomeController(ItemRepository itemRepository, Cart cart) {
        this.itemRepository = itemRepository;
        this.cart = cart;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "index";
    }

    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable("itemId") Long itemId, Model model) {

        Optional<Item> oItem = itemRepository.findById(itemId);
        if(oItem.isPresent()){
            Item item = oItem.get();
            cart.addItem(item);
        }
        model.addAttribute("items", itemRepository.findAll());
        return "index";
    }

}
