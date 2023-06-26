puts "Hello world! (1)"

BEGIN { # to be executed first, when the file loads up
  puts "codigo dentro do begin"
}

puts "Hello world! (2)"


END { # to be executed first, when the file loads up
    puts "codigo dentro do end"
}