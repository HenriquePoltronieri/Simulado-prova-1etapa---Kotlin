open class Cafeteira(
    open var marca: String,
    open var nivelAgua: Int = 0
){
    open fun abastecerAgua(quantidade: Int) {
        nivelAgua += quantidade
        if (nivelAgua > 1000) {
            print("Cafeteira cheia(1000ml)\n")
        } else if (nivelAgua < 0){
            print("Valor inválido! Nivel da água abixo de 0 ml.\n")
        } else {
            print("Abastecimento realizado. Nível atual: ${nivelAgua}ml\n")
        }
    }
    open fun fazerCafe(tamanho: Int): String {
        var aguaGasta: Int = 0

        if (tamanho == 1) {
            aguaGasta = 50
        } else if (tamanho == 2) {
            aguaGasta = 100
        } else {
            return "Água insulficiente ou valor inválido!\n"
        }

        if (nivelAgua >= aguaGasta) {
            nivelAgua -= aguaGasta
            return "Café pronto!"
        } else {
            return "Água insulficiente ou valor inválido!\n"
        }
    }
}


fun main() {
    var minhaCafeteira = Cafeteira("Nespresso")
    var opcaoMenu: Int = 0

    while (opcaoMenu != 4) {
        println("\n===== Cafeteria do Cotemig - ${minhaCafeteira.marca.uppercase()} =====")

        println("O que você deseja fazer?")
        print("1 Abastecer Água\n")
        print("2 Fazer Café Pequeno\n")
        print("3 Fazer Café Grande\n")
        print("4 Desligar\n")
        print("Escolha uma opção: \n")

        opcaoMenu = readln().toInt()

        when(opcaoMenu){
            1 -> {
                print("Inira a quantidade de água")
                val quantidade = readln().toInt()
                minhaCafeteira.abastecerAgua(quantidade)
            }
            2 -> {
                val retorno = minhaCafeteira.fazerCafe(1)
                print("${retorno}\n\n")
            }
            3 -> {
                val retorno = minhaCafeteira.fazerCafe(2)
                print("${retorno}\n\n")
            }
            4 -> {
                print("Desligando cafeteira!\n\n")
            }
            else -> {
                print("Opção inválida.\n\n")
            }
        }
    }
}
