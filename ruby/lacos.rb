i = 0
while i < 10
    i+=1
end
puts i

begin
    i+=1
end while i < 20
puts i

for i in 0..5
    puts "Value of local variable is #{i}"
end

(0..5).each do |i|
    puts "Value of local variable is #{i}"
end


puts 10.times { |i| print i, " " }

restart = false
  
# Using for loop
for x in 2..20
    if x == 15
        if restart == false
  
            # Printing values
            puts "x=#{x} Re-doing when x = " + x.to_s
            restart = true
  
            # Using Redo Statement
            redo
        end
    end
    puts x
end