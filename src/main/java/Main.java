import model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Funcionario funcionarioMaria = new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador");
        Funcionario funcionarioJoao = new Funcionario("Joao", LocalDate.of(1990, 5, 12), BigDecimal.valueOf(2284.38), "Operador");
        Funcionario funcionarioCaio = new Funcionario("Caio", LocalDate.of(1961, 5, 02), BigDecimal.valueOf(9836.14), "Coordenador");
        Funcionario funcionarioMiguel = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.88), "Diretor");
        Funcionario funcionarioAlice = new Funcionario("Alice", LocalDate.of(1995, 1, 05), BigDecimal.valueOf(2234.68), "Recepcionista");
        Funcionario funcionarioHeitor = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador");
        Funcionario funcionarioArthur = new Funcionario("Arthur", LocalDate.of(1993, 3, 31), BigDecimal.valueOf(4071.84), "Contador");
        Funcionario funcionarioLaura = new Funcionario("Laura", LocalDate.of(1994, 7, 8), BigDecimal.valueOf(3017.45), "Gerente");
        Funcionario funcionarioHeloisa = new Funcionario("Heloisa", LocalDate.of(2003, 05, 24), BigDecimal.valueOf(1606.85), "Eletricista");
        Funcionario funcionarioHelena = new Funcionario("Helena", LocalDate.of(1996, 9, 2), BigDecimal.valueOf(2799.93), "Gerente");

        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(funcionarioMaria);
        funcionarios.add(funcionarioJoao);
        funcionarios.add(funcionarioCaio);
        funcionarios.add(funcionarioMiguel);
        funcionarios.add(funcionarioAlice);
        funcionarios.add(funcionarioHeitor);
        funcionarios.add(funcionarioArthur);
        funcionarios.add(funcionarioLaura);
        funcionarios.add(funcionarioHeloisa);
        funcionarios.add(funcionarioHelena);


        //Removendo funcionario joão
        funcionarios.remove(funcionarioJoao);


        //Imprimindo todos os funcionarios
        for (Funcionario f : funcionarios) {
            f.mostrarDados();
        }


        //Aumentando salarios em 10%
        for (Funcionario f : funcionarios) {
            f.aumentarSalario();
        }

        //Imprimindo funcionarios por função
        Map<String, List<Funcionario>> funcionariosFuncao = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao, HashMap::new, Collectors.toList()));
        funcionariosFuncao.forEach((funcao, listaFuncionarios) -> {
            System.out.println("Funcao: " + funcao);
            listaFuncionarios.forEach(funcionario -> System.out.println("  - " + funcionario.getNome()));
        });

        //Imprimindo funcionarios que nasceram no mes 10 ou 12
        for (Funcionario f : funcionarios) {
            f.imprimirFuncionariosMes();
        }

        //Imprimindo funcionario mais velho
        Funcionario funcMaisMelho = funcionarios.get(0);
        for (Funcionario func : funcionarios) {
            if (func.getDataNascimento().isBefore(funcMaisMelho.getDataNascimento())) {
                funcMaisMelho = func;
            }
        }
        long idade = ChronoUnit.YEARS.between(funcMaisMelho.getDataNascimento(), LocalDate.now());
        System.out.println("Nome: " + funcMaisMelho.getNome() + " Idade: " + idade);

        //Imprimindo salario de todos os funcionarios somados
        BigDecimal salariosTotal = BigDecimal.ZERO;
        for (Funcionario f : funcionarios) {
            salariosTotal = salariosTotal.add(f.getSalario());
        }
        funcionarioMaria.salariosSomados(salariosTotal);

        //Imprimindo quantos salarios minimos cada funcionarios recebe
        for (Funcionario f : funcionarios) {
            f.salarioMinimoPorFuncionario();
        }


    }
}
