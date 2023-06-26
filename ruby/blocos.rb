[1, 2, 3].each { |n| puts n }
[1, 2, 3].each do |n|
    puts n
end


def say_my_age
    if block_given?
        yield
    else
        puts "You didn't give me your age"
    end
end


say_my_age { puts "Ten say_my_age" }
say_my_age


#parametros para o bloco


# def bloco_com_parametros (valor, &block)
#     block.call(valor)
# end
def bloco_com_parametros (valor)
    yield valor
end

bloco_com_parametros(50) { |i| puts "seu valor é #{i}"}