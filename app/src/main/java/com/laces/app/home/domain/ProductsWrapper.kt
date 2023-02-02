package com.laces.app.home.domain

data class ProductsWrapper(
    val products: List<ProductModel>,

    val total: Int,

    )