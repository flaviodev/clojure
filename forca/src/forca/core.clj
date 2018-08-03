(ns forca.core
  (:gen-class))

(def total-de-vidas 6)

(defn perdeu [] (print "você perdeu "))

(defn ganhou [] (print "você ganhou! "))


(defn letras-faltantes [palavra acertos]
  (
    ;; remove function collection 
    ;; if function returns true remove item from collection
    ;; ex: (remove (fn[x] (= x 2)) #{1 2 3}) -> return 1 3
    remove (fn [letra](contains? acertos (str letra))) palavra
  )
)

(defn acertou-a-palavra-toda? [palavra acertos]
  (empty? (letras-faltantes palavra acertos))
)

(defn jogo [vidas palavra acertos]
   (if (= vidas 0)
      (perdeu) ;; then
      (if (acertou-a-palavra-toda? palavra acertos) ;; else if
        (ganhou)  ;; then
        (print "Chuta, amigo! ") ;; else
      )
   )
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;;reload  
(defn r [] (require '[forca.core :as forca] :reload))

(defn is-par [numero] (= 0 (rem numero 2)))

;; (disj numeros 1) subtract item from collection
;; (sort numeros)
;; (filter (fn [x] (> x 2)) numeros)
;; (map (fn [x] (* x 3)) numeros)
;; (or true false)
;; (and true true)
