package model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Funcionario extends Pessoa{

    public Funcionario(String nome, LocalDate dataNascimento) {
        super(nome, dataNascimento);
    }
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void mostrarDados(){
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataNascimentoFormatada = getDataNascimento().format(formatacao);

        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(new Locale("pt", "BR"));
        df.applyPattern("#,##0.00");
        String salarioFormatado = df.format(salario);


        System.out.println("Nome: " + this.getNome() + " Data Nascimento: " + dataNascimentoFormatada + " Salario: " + salarioFormatado + " Funcao: " + funcao);
    }

    public void aumentarSalario(){
        BigDecimal aumento = new BigDecimal("1.10");
        this.salario = salario.multiply(aumento);
    }

    public void imprimirFuncionariosMes(){
        if(this.getDataNascimento().getMonthValue()  == 12 || this.getDataNascimento().getMonthValue() == 10){
            mostrarDados();
        }
    }

    public void salariosSomados(BigDecimal salarios){
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(new Locale("pt", "BR"));
        df.applyPattern("#,##0.00");

        String salariosFormatado = df.format(salarios);

        System.out.println("Soma de todos os salarios: " + salariosFormatado);
    }

    public void salarioMinimoPorFuncionario(){
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        BigDecimal quantidadeSalariosMinimos = getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_DOWN); // Arredondar para baixo
        System.out.println("Nome: " + getNome() + " Quantidade de salarios minimos: " + quantidadeSalariosMinimos);
    }

}
