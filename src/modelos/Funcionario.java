/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;
import java.io.IOException;
/**
 *
 * @author Gabriel Ribeiro
 */
public class Funcionario {
    
    private int matricula;
    private String nomeFuncionario;
    private int qtdDependentes;
    private double salario;
    private int qtdProducao;

    public Funcionario() {
    }

    public Funcionario(int matricula, String nomeFuncionario, int qtdDependentes, double salario, int qtdProducao)throws Exception {
        if(matricula < 0) throw new Exception("Matricula não pode ser < 0");
        this.matricula = matricula;
        if(nomeFuncionario.isEmpty()) throw new Exception("Nome não pode estar vazia");
        this.nomeFuncionario = nomeFuncionario;
        if(qtdDependentes < 0) throw new Exception("Quantidade de Dependentes não pode ser < 0");
        this.qtdDependentes = qtdDependentes;
        if(salario < 0) throw new Exception("Salario não pode ser < 0");
        this.salario = salario;
        if(qtdProducao < 0) throw new Exception("Quantidade de Produção não pode ser < 0");
        this.qtdProducao = qtdProducao;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula)throws Exception {
        if(matricula < 0) throw new Exception("Matricula não pode ser < 0");
        this.matricula = matricula;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario)throws Exception {
        if(nomeFuncionario.isEmpty()) throw new Exception("Nome não pode estar vazia");
        this.nomeFuncionario = nomeFuncionario;
    }

    public int getQtdDependentes() {
        return qtdDependentes;
    }

    public void setQtdDependentes(int qtdDependentes)throws Exception {
        if(qtdDependentes < 0) throw new Exception("Quantidade de Dependentes não pode ser < 0");
        this.qtdDependentes = qtdDependentes;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) throws Exception{
        if(salario < 0) throw new Exception("Salario não pode ser < 0");
        this.salario = salario;
    }
    
    public int getQtdProducao(){
        return qtdProducao;
    }
    
    public void setQtdProducao(int qtdProducao)throws Exception{
        if(qtdProducao < 0) throw new Exception("Quantidade de Produção não pode ser < 0");
        this.qtdProducao = qtdProducao;
    }
    
    public int calcularGratificacao(){
        if(qtdProducao <= 1000)return 500;
        if(qtdProducao <= 2000)return 1250;
        return 2250;
    }
    
    public double calcularSalarioBruto(){
        int gratificacao = calcularGratificacao();
        double salario = getSalario();
        return (salario + gratificacao);
    }

    public double calcularDescontosINSS(){
       double salarioBruto = calcularSalarioBruto();
       if(salarioBruto <= 1412.00) return(salarioBruto * 0.075); 
       if(salarioBruto <= 2666.68) return(salarioBruto * 0.09);
       if(salarioBruto <= 4000.03) return(salarioBruto * 0.12);
       return (salarioBruto * 0.14);
    }
    
    public double calcularDescontosIRPF(){
       double salarioBruto = calcularSalarioBruto(); 
       if(salarioBruto <= 2259.20) return 0;
       if(salarioBruto <= 2826.65) return(salarioBruto * 0.075);
       if(salarioBruto <= 3751.05) return(salarioBruto * 0.15);
       if(salarioBruto <= 4664.68) return(salarioBruto * 0.225);
       return (salarioBruto * 0.275);   
    }
    
    public double calcularDescontoPorDependencia(){
        if(qtdDependentes == 0) return 0;
        return (qtdDependentes * 123);
    }
    
    public double calcularSalarioLiquido(){
        double salarioBase = salario + calcularGratificacao();
        double descontoINSS = calcularDescontosINSS();
        double descontoIRPF = calcularDescontosIRPF();
        double descontoDependencia = calcularDescontoPorDependencia();
        if((descontoIRPF - descontoDependencia) < 0){
        return salarioBase - descontoINSS;   
        } 
        return((salarioBase - descontoINSS)-(descontoIRPF - descontoDependencia));
    }
    
}
