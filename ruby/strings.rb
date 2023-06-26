
nome = 'rafa'
nome2 = "rafa"
puts nome == nome2
#Unlike the == operator which tests if both operands are equal, the equal method checks if the two operands refer to the same object. 
puts nome.equal? nome2

# interpolação
puts "Olá #{nome}"
puts 'Olá #{nome2}'


# objetos
nome3 = String.new "rafa"
puts nome == nome3
# the equal method checks if the two operands refer to the same object
puts nome.equal? nome3
#For objects of class Object, eql? is synonymous with ==
puts nome.eql? nome3

# array de strings

puts nome[0].class
puts nome[1]
puts nome[2]
puts nome[3]
puts nome[-1]
puts nome[-2]
puts nome[-3]
puts nome[-4]

#slicing
# inicio e número de caracteres
puts nome[1,2]
puts nome[1..3]


# strings com int

idade1 = "10"
idade2 = 10
puts idade1.class

puts idade1 == idade2
puts idade1 === idade2

# puts "Ola vc tem #{idade1 + idade2}"
puts "Ola vc tem #{idade1.to_i + idade2}"
puts "Ola vc tem #{idade1 + idade2.to_s}"

# métodos

puts nome.capitalize
puts nome.upcase
puts nome.downcase
puts nome.size
partes = "raphael henrique lacerda pinho".split
puts partes [0]
puts partes [1]