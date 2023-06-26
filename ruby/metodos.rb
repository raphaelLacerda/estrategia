def test
    i = 100
    j = 10
    k = 30
    # return i, j, k
end
# qual método será retornado

puts test
# puts test[0]


def sample (*test)
    puts "The number of parameters is #{test.length}"
    for i in 0...test.length
       puts "The parameters are #{test[i]}"
    end
 end
 sample "Zara", "6", "F"
 sample "Mac", "36", "M", "MCA"


 def geeks (var1 = "GFG", var2 = "G4G")
 
    #  statements to be executed
    puts "First parameter is #{var1}"
    puts "First parameter is #{var2}"
end

# calling method with parameters
geeks "GeeksforGeeks", "Sudo"
 
puts ""
 
puts "Without Parameters"
puts ""
# calling method without passing parameters
geeks