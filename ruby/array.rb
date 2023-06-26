dados = [  "fred", 10, 3.14, "This is a string", "last element", 10]

puts dados.class
puts dados[2,2]
puts dados[2 .. 3]

puts "todos================"

# funcional
dados.each do |v|
    puts "valor #{v}"
end

# imperativo
for x in dados
    puts "valor #{x}"
end




dados = Array.new(10)
# dados = Array.new(10, 5)
dados = Array[1,2,3,4,5]
# nums = Array.[](1, 2, 3, 4,5)
nums = Array.new(10) { |e| e = e * 2 }

# collect operator
novos_dados = dados.collect {|x| 10*x}
puts novos_dados


puts "#{nums}"
# (1..5)        #==> 1, 2, 3, 4, 5
# (1...5)       #==> 1, 2, 3, 4
(0...10).each do |i|
    dados[i] = i
    # dados.append(i) # adiciona elementos ao final
    # dados.push(i) # adiciona elementos ao final
end
dados[-2] = 9
# puts dados
puts dados.size
puts dados.length
# puts dados.count 9
# puts dados.count {|i| i > 3}

# adicionando novos elementos
# dados[12] = 12
# puts dados.length

# métodos

puts dados.include?(1)  