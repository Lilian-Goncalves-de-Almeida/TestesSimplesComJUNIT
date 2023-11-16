# TestesSimplesComJUNIT


Estudo de testes unitários com JUnit


## Exemplos

### Anotations usadas
#### @Before
Diz que o método será rodado antes dos outros pela aplicação.
```java
...
    @Before
    public void iniciarLista(){
        lista = new ArrayList<String>();
    }
...
```
Nesta aplicação foi usada para iniciar a lista para os testes.

#### @After
Diz que o método será rodado depois final da compilação pela aplicação.
```java
...
    @After
    public void limparLista(){
        lista = null;
    }
...
```
Nesta aplicação foi usado para limpar a lista ao final dos testes.

#### @Test/@Test()
Usados para indicar quando um método era um teste.
```java
...
    @Test
    public void listaEstaVaziaTeste(){
        Assert.assertTrue(lista.isEmpty());
    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void tipoDeExceptionTeste() {
        lista.get(0);
    }
...
```
O @Test() foi usado para indicar qual era a classe de exceção esperada como resposta. 


### Asserts usados

#### assertEquals
Testou se a resposta obtida estava de acordo com o previsto.
```java
...
    @Test
    public void comprimentoTeste(){
        Assert.assertEquals(0, lista.size());
        lista.add("a");
        Assert.assertEquals(1, lista.size());
        lista.remove("a");
        Assert.assertEquals(0, lista.size());
    }
        @Test
    public void listaComparandoMensagemErroTeste(){
        Exception t = Assert.assertThrows(RuntimeException.class, ()-> lista.remove(1));
        Assert.assertEquals("Index 1 out of bounds for length 0", t.getMessage());
    }
...
```
No primeiro foi testado o comprimento da lista com ela vazia e com um elemento.
No segundo foi usado para comparar a mensagem de exceção.

#### assertTrue
Usado para verificar a veracidade de uma resposta.
```java
...
    @Test
    public void listaEstaVaziaTeste(){
        Assert.assertTrue(lista.isEmpty());
    }
        @Test
    public void listaVerficandoMensagemErroTeste(){
        Exception t = Assert.assertThrows(IndexOutOfBoundsException.class, ()->lista.get(0));
        Assert.assertTrue(t.getMessage().contains(""));
    }
...
```
Verificou-se se a lista estava vazia, e se a variável t recebeu uma menssagem como previsto.

#### assertThrows
Usado para testar as respostas de exceções.
```java
...
    @Test
    public void listaVerficandoMensagemErroTeste(){
        Exception t = Assert.assertThrows(IndexOutOfBoundsException.class, ()->lista.get(0));
        Assert.assertTrue(t.getMessage().contains(""));
    }
        @Test
    public void listaComparandoMensagemErroTeste(){
        Exception t = Assert.assertThrows(RuntimeException.class, ()-> lista.remove(1));
        Assert.assertEquals("Index 1 out of bounds for length 0", t.getMessage());
    }
...
```

Usando assertTrue e assertEquals, foi testado a igualdade da mensagem para o teste, e se o teste havia gerado uma exceção.



## Referência

 - [Gerador de readme online](https://readme.so/pt)
 - [Qualidade e JUnit: introdu...](https://mari-azevedo.medium.com/qualidade-e-junit-introduzindo-automatiza%C3%A7%C3%A3o-de-testes-unit%C3%A1rios-do-seu-software-java-no-dia-a-dia-849611de5574)
 - [JUnit Wiki](https://pt.wikipedia.org/wiki/JUnit)
 - [JUnit 5: How to assert an exception is thrown?](https://stackoverflow.com/questions/40268446/junit-5-how-to-assert-an-exception-is-thrown)

