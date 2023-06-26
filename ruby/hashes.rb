# hsh = Hash.new
hsh = colors = { "red" => 0xf00, "green" => 0x0f0, "blue" => 0x00f }
# hsh = Hash["red"=> 0xf00, "green"=> 0x0f0]
hsh.each do |key, value|
   print key, " is ", value, "\n"
end


puts hsh.keys
puts hsh["red"]

puts hsh.fetch("blue")

# Hashes have a default value that is returned when accessing keys that do not exist in the hash. I
hsh.default = "Not Found"

puts hsh["pink"]

hsh.each_key {|key| puts key }

puts "----------------"
puts hsh.flatten[1]