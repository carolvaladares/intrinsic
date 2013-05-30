import scala.io.Source

/****
 * Esse é um pequeno exercício para demonstrar o uso do Scala para processar textos.
 * Complete o conteúdo das funções abaixo e poste seu resultado no Github
 *  
 * Atenção: se você não é fluente em Scala, não se desanime caso não saiba resolver o problema de forma rápida
 *          A ideia aqui é demonstrar que você é capaz de aprender novas linguagens. Google te ajudará bastante ;-)
 *          
 * Instrução: Apague o termo ??? das funções e coloque o seu código.         
 *          
 */


class StopWords {

  override def toString = lista.toString
  
  /* Essa função armazena uma lista de stopwords */
  val lista = getStopWords()

  /*
   * Esta função deve devolver uma lista de stopwords. 
   * A lista de stopwords está neste endereço: "http://members.unine.ch/jacques.savoy/clef/englishST.txt"
   * 
   * A função deve: 
   *    1 - Ler as stopwords à partir da URL acima
   *    2 - Transformar o conteúdo em uma lista
   *    3 - Retornar uma lista contendo todas as palavras com mais de uma letra (palavras com tamanho maior que 1). 
   *    
   */ 
  def getStopWords():List[String] = {
    
    val url = "http://members.unine.ch/jacques.savoy/clef/englishST.txt"
	val lines = scala.io.Source.fromURL(url).getLines.toList
	
    return lines.filter(_.length >= 1)

  }

 /*
  * A função part divide a lista de stopwords já filtradas pela função getStopWords em duas partes: uma contendo todas as entradas com uma certa letra e outra sem a letra
  * 
  * Dica: a função part retorna o que o Scala chama de pairs. verifique o método "partition" no Scala.
  * 
  */
 
  def part (c: String) = {
    
    val list = getStopWords()
    val (left, right) = list partition (_.contains(c))
    
    println("Palavras contendo " + c + "\n");
    for ( p <- left)
    	print(p + ", ");
    
    println("\n\nPalavras que não contém " + c + "\n");
    for ( p <- right)
		print(p + ", ");
  }

}

object StopWordsObj {

  

  // Você pode rodar seu código para verificar se ele funciona. 
  // Aqui ele imprimirá quantas palavras com contração estão na lista de stopwords (deve ser 47) e quantas sem contração (deve ser 498).
  def main(args: Array[String]) {
    
    val spwords = new StopWords()
    spwords.part("b")
   
    // spwords.getStopWords()
    
   //  val (contracao, semcontracao) = (spwords part "'")
   // System.out.println("Palavras com contração: " + contracao.size);
   // System.out.println("Palavras sem contração: " + semcontracao.size);

  }
}