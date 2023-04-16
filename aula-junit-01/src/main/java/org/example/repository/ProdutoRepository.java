package org.example.repository;

import org.example.domain.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoRepository {
    private static List<Produto> listaProduto = new ArrayList<>();

    public Produto salvarProduto(Produto produto) {
        listaProduto.add(produto);
        return produto;
    }

    public void removerProduto(Produto produto) {
        listaProduto.remove(produto);
    }

    public List<Produto> listarProdutos() {
        return listaProduto;
    }
}
