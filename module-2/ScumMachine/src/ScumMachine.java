import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ScumMachine<T> {

    public T doMonoOperation(MonoOperation<T> operation, T arg1) {
        return operation.execute(arg1);
    }

    public T doBiOperation(BiOperation<T> operation, T arg1, T arg2) {
        return operation.execute(arg1, arg2);
    }

    public static void main(String[] args) {
        ScumMachine<Integer> integerMachine = new ScumMachine<>();
        ScumMachine<String> stringMachine = new ScumMachine<>();
        ScumMachine<Boolean> booleanScumMachine = new ScumMachine<>();

        MonoOperation<Integer> aoQuadrado = (n1) -> n1 * n1;
        BiOperation<Integer> add = (n1, n2) -> n1 + n2;
        MonoOperation<String> myName = (s1) -> "my name is: " + s1;
        BiOperation<String> fullName = (s1, s2) -> "my full name is: " + s1 + " " + s2;
        BiPredicate<Integer, Integer> compare = (n1, n2) -> n1 > n2;



        //TODO:adicionar metodo filter and map, utilizar predicate para filtrar;
        //TODO:faz a mesma operacao sobre todos os valores da collection e adiciona a outra collection;

        System.out.println(integerMachine.doMonoOperation(aoQuadrado, 2));
        System.out.println(integerMachine.doBiOperation(add, 3, 5));
        System.out.println(stringMachine.doMonoOperation(myName, "Rodrigo"));
        System.out.println(stringMachine.doBiOperation(fullName, "Rodrigo", "Dinis"));

    }
}
