using System;
// using Classes.Pessoa;

namespace HelloWorldApplication {
   struct Pessoa{
      public string nome;
   }
   class Dia{
      public int Valor {get;set;}
      public static Dia operator +(Dia d1, Dia d2){
         var novo = new Dia();
         novo.Valor = d1.Valor + d2.Valor;
         return novo;
      }
   }
   class OlaMundo {
      static void Main(string[] args) {
         /* my first program in C# */
         Pessoa p = new Pessoa();
         p.nome = "guilherme";
         Console.WriteLine($"Ola Mundo {p.nome}");
         Dia d1 = new Dia();
         d1.Valor = 10;
         Dia d2 = new Dia();
         d2.Valor = 4;
         Dia d3 = d1+d2;
         Console.WriteLine($"Novo dia {d3.Valor}");



      }
   }
}