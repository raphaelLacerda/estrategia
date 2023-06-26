#CONSTANTES

PI = 3.16
a = 3* 3.16
puts a
puts a.class

# PI = 3.2r
# a = 3* 3.16
# puts a


nome = "rafa"
idade = 10

idade+=1

puts idade
puts idade.class


puts "Seu nome é #{nome} e sua idade #{idade}"
puts "seu nome é ", nome, " e sua idade ", idade
print "seu nome é ", nome, " e sua idade ", idade


idade, idade2 = 20, 30

maior = idade > 10? true : false

puts maior

# defined

puts defined? idade
puts defined? PI
puts defined? rafa


#When comparing numbers of different types (e.g., integer and float), if their numeric value is the same, == will return true.
puts 1 == 1.0
puts 1.class
puts 1.0.class
