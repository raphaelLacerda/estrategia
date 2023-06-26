begin
    file = open("/unexistant_file")
    if file
       puts "File opened successfully"
    end
 rescue
       file = STDIN
 end
 print file, "==", STDIN, "\n"


 begin

    1/0

    rescue ZeroDivisionError => e
        puts e.class
        puts e.message
        puts e.backtrace
    ensure
        puts "finalmente vai ser executado"

 end

 

 # propria exception
 begin
    # raises an ArgumentError with the message "you messed up!"
    raise ArgumentError.new("You messed up!")
  rescue ArgumentError => e  
    puts e.message
  end


  class PermissionDeniedError < StandardError

  end
  
  raise PermissionDeniedError.new()
 