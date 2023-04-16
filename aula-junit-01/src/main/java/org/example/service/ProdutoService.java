package org.example.service;

import org.example.domain.Produto;
import org.example.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public Produto criarESalvarProduto(String nome, Double valor, Integer codigo_barras) throws Exception {
        if(valor >= 200.00) {
            valor += 10.00;
        }
        if(valor <= 0) throw new Exception("O valor não pode ser menor que 0");
        Produto novoProduto = new Produto(nome, valor, codigo_barras);
        return produtoRepository.salvarProduto(novoProduto);
    }
}
