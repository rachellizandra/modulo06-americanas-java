package org.example.service;

import org.example.domain.Produto;
import org.example.repository.ProdutoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {
    @InjectMocks
    ProdutoService produtoService;

    @Mock
    ProdutoRepository produtoRepository;

    @Test
    public void testarAdicionarESalvarProduto() throws Exception {
        String nome = "relogio";
        Double valorInicial = 200.00;
        Integer codigo_barras = 1;

        Double valorEsperado = 210.00;
        Produto produtoMockado = new Produto(nome, valorEsperado, codigo_barras);

        Mockito.when(produtoRepository.salvarProduto(Mockito.any())).thenReturn(produtoMockado);

        Produto produtoCriado = produtoService.criarESalvarProduto(nome, valorInicial, codigo_barras);

        Assertions.assertEquals(nome, produtoCriado.getNome());
        Assertions.assertEquals(valorEsperado, produtoCriado.getValor());
        Assertions.assertEquals(codigo_barras, produtoCriado.getCodigo_barras());

        Mockito.verify(produtoRepository, Mockito.times(1)).salvarProduto(Mockito.any());

    }

}