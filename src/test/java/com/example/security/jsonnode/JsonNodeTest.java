package com.example.security.jsonnode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class JsonNodeTest {

//    @Test
//    void simpleCodeTest() throws JsonProcessingException {
//        String jsonstring = """
//                              {
//                  "id": 1,
//                  "name": "Leanne Graham",
//                  "username": "Bret",
//                  "email": "Sincere@april.biz",
//                  "address": {
//                    "street": "Kulas Light",
//                    "suite": "Apt. 556",
//                    "city": "Gwenborough",
//                    "zipcode": "92998-3874",
//                    "geo": {
//                      "lat": "-37.3159",
//                      "lng": "81.1496"
//                    }
//                  },
//                  "phone": "1-770-736-8031 x56442",
//                  "website": "hildegard.org",
//                  "company": {
//                    "name": "Romaguera-Crona",
//                    "catchPhrase": "Multi-layered client-server neural-net",
//                    "bs": "harness real-time e-markets"
//                  }
//                  "languages":["Java","Python","C++"]
//                }
//                """;
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode rootNode = objectMapper.readTree(jsonstring);
//        JsonNode username = rootNode.get("username");
//        System.out.println(username.asText());
//
//        System.out.println(rootNode.at("/address/geo/lat").asDouble());
//    }


    @Test
    void traverseRoot() throws Exception {
        String jsonstring = """
                  {
                  "id": 1,
                  "name": "Leanne Graham",
                  "username": "Bret",
                  "email": "Sincere@april.biz",
                  "address": {
                  "street": "Kulas Light",
                  "suite": "Apt. 556",
                  "city": "Gwenborough",
                  "zipcode": "92998-3874",
                  "geo": {
                  "lat": "-37.3159",
                  "lng": "81.1496"
                  }
                  },
                  "phone": "1-770-736-8031 x56442",
                  "website": "hildegard.org",
                  "company": {
                  "name": "Romaguera-Crona",
                  "catchPhrase": "Multi-layered client-server neural-net",
                  "bs": "harness real-time e-markets"
                  },
                  "languages":["java","C","C#"]
                  }
                """;
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonstring);
        traverse(rootNode);
    }

    void traverse(JsonNode rootNode){

        if (rootNode.isObject()){
            Iterator<String> fieldNames = rootNode.fieldNames();

            while (fieldNames.hasNext()){
                String next = fieldNames.next();
                JsonNode jsonNode = rootNode.get(next);
                traverse(jsonNode);
            }

        } else if (rootNode.isArray()) {
            for (JsonNode jsonNode : rootNode) {
                traverse(jsonNode);
            }
            
        }else {
            System.out.println(rootNode.asText());
        }

    }
}