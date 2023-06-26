module A
    MAXIMO = 2
    def a1
        puts "a1"
    end
    def a2
        puts "a2" 
    end
 end
 module B
    def b1
        puts "b1"
    end
    def b2
        puts "b2"
    end
 end
 
 class Sample
 include A
 include B
    def s1
        puts "O maximo é #{A::MAXIMO}"
    end
 end
 
 samp = Sample.new
 samp.a1
 samp.a2
 samp.b1
 samp.b2
 samp.s1