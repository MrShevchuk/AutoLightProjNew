package com.brainacad.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    /**
     * Идентификатор.
     */
    private UUID id;

    /**
     * Название.
     */
    private String title;

    /**
     * Описание.
     */
    private String description;
}
