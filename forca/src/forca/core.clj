(ns forca.core(:gen-class))

(def total-de-vidas 6)

(defn perdeu [] (print "você perdeu "))

(defn ganhou [] (print "você ganhou! "))

(defn le-letra! [] (read-line))

(defn acertou? [chute palavra] (.contains palavra chute))

(defn avalia-chute [chute vidas palavra acertos]
  (if(acertou? chute palavra)
    (jogo vidas palavra (conj acertos chute))
    (jogo (dec vidas) palavra acertos)))

(defn letras-faltantes [palavra acertos]
  (remove (fn [letra](contains? acertos (str letra))) palavra))

(defn acertou-a-palavra-toda? [palavra acertos]
  (empty? (letras-faltantes palavra acertos)))

(defn imprime-forca [vidas palavra acertos]
  (println "Vidas " vidas)
  (doseq [letra (seq palavra)]
    (if (contains? acertos (str letra))
      (print letra " ")
      (print "_" " "))) 
  (println))

(defn jogo [vidas palavra acertos]
   (imprime-forca vidas palavra acertos)
   (cond
      (= vidas 0) (perdeu) 
      (acertou-a-palavra-toda? palavra acertos) (ganhou) 
      :else 
        (let [chute (le-letra!)]
          (if (acertou? chute palavra)
            (do 
              (println "Acertou a letra! ")
              (recur vidas palavra (conj acertos chute)))
            (do 
              (println "Erro a letra! Perdeu vida! ")
              (recur (dec vidas) palavra acertos))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;;reload  
(defn r [] (require '[forca.core :as forca] :reload))

(defn is-par [numero] (= 0 (rem numero 2)))

(defn fib[x]
    (loop [a 1 b 1 numero 2]
        (if 
            (= numero x) b
            (recur b (+ a b) (inc numero))
        )
    ))

(defn soma[n] 
    (loop [contador 1 soma 0]
        (if (> contador n) soma
        (recur (inc contador) (+ soma contador)))))

;; (dec numero) numero--
;; (inc numero) numero++
;; (conj numeros 1) add item to collection
;; (disj numeros 1) subtract item from collection
;; (sort numeros)
;; (filter (fn [x] (> x 2)) numeros)
;; (map (fn [x] (* x 3)) numeros)
;; (or true false)
;; (and true true)
;; (.contains palavra chute) invoke contains of java
;; do agrupa eventos
;; cond agrupa condições
;; recur aplica recursao de cauda que impede o empilhamento de invocacao dos metodos (deve ser a última linha da funcao)