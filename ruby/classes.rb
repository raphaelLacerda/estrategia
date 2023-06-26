$global_variable = 20

class Veiculo
    @quantidade_assentos = 0
    @potencia = 0
    @modelo
    #must be initialized before they can be used in method definitions.
    @@total = 0
    #modelo e potencia como variaveis locais
    #@ sao as variaveis de instancia
    def initialize(modelo, potencia)
        @modelo = modelo
        @potencia = potencia
        @@total = @@total+1
     end

    def acelerar
        return $global_variable
    end

    def potencia
        @potencia
    end
    # A class method is defined using def self.total
    def self.total
        # Return the value of this variable
        @@total
    end

    def to_s
        "(w:#@modelo,h:#@potencia)"  # string formatting of the object.
    end

    def +(veiculo)
        @potencia + veiculo.potencia
    end

end

class Carro < Veiculo
    
    def nome=(novo_nome)
            @nome = novo_nome

    end 
    # def nome
    #     return @nome
    # end

    def nome
        @nome
    end

    def acelerar
        if @modelo.start_with? "pegeout"
            return nitro            
        end
        @potencia = @potencia+1
    end

    def nitro
        @potencia = @potencia * 1000
    end

    private :nitro

end


=begin
class Carro < Veiculo
    attr_reader :nome
    attr_writer :nome
    attr_accessor: nome
end
=end

c = Carro.new("pegeout", 200)
c1 = Carro.new("jeep", 100)
c.nome = "rafa"
puts c.respond_to?("acelerar")
puts c.respond_to?("freiar")
puts "ola #{c.nome} - #{c.acelerar}"
# c.freeze
puts "ola #{c.nome} - #{c.acelerar}"


#acessando por self
puts "Total - #{Carro.total}"

puts c

puts c+c1


# puts Carro.instance_methods
puts Carro.instance_methods(false)