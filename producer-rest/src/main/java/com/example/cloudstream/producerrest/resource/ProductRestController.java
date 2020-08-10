package com.example.cloudstream.producerrest.resource;

import com.example.cloudstream.producerrest.dto.Message;
import com.example.cloudstream.producerrest.message.RestProducer;
import com.example.cloudstream.producerrest.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    private RestProducer restProducer;

    @PostMapping("/process")
    @ResponseBody
    public Message processProduct(@RequestBody Product product) {
        boolean result = restProducer.sendMessageProduct(product);

        return new Message("Operação realizada com sucesso? " + result);
    }
}
