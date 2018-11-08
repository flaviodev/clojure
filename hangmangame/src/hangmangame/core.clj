(ns hangmangame.core
  (:gen-class))

(def total-lives 6)
(def secret-word "recursion")

(defn lost [] (print "You lost! "))

(defn won [] (print "You won! "))

(defn read-letter! [] (read-line))

(defn hit? [shot word] (.contains word shot))

(defn missing-letters [word hits]
  (remove (fn [letter](contains? hits (str letter))) word))

(defn  hit-the-whole-word? [word hits]
  (empty? (missing-letters word hits)))

(defn print-hangmangame [lives word hits]
  (println "Lives " lives)
  (doseq [letter (seq word)]
    (if (contains? hits (str letter))
      (print letter " ")
      (print "_" " "))) 
  (println))

(defn game [lives word hits]
   (print-hangmangame lives word hits)
   (cond
      (= lives 0) (lost) 
      ( hit-the-whole-word? word hits) (won) 
      :else 
        (let [shot (read-letter!)]
          (if (hit? shot word)
            (do 
              (println "You hit the letter! ")
              (recur lives word (conj hits shot)))
            (do 
              (println "You missed the letter! You lost a life! ")
              (recur (dec lives) word hits))))))

(defn  start-the-game [] (game total-lives secret-word #{}))

(defn -main [& args]
  ( start-the-game))

;;reload  
(defn r [] (require '[hangmangame.core :as hangmangame] :reload))

(defn it-is-even [number] (= 0 (rem number 2)))

(defn fib[x]
    (loop [a 1 b 1 number 2]
        (if 
            (= number x) b
            (recur b (+ a b) (inc number))
        )
    ))

(defn sum[n] 
    (loop [counter 1 sum 0]
        (if (> counter n) sum
        (recur (inc counter) (+ sum counter)))))

(defn print-sequence[]
  (def cars [10,20,30])
  (->> cars 
    (map (fn[x](* x 2)))
    (map (fn[x](* x 2)))
    (reduce (fn[acc x](+ acc x)))
  )
)

;; (dec number) number--
;; (inc number) number++
;; (conj numbers 1) add item to collection
;; (disj numbers 1) subtract item from collection
;; (sort numbers)
;; (filter (fn [x] (> x 2)) numbers)
;; (map (fn [x] (* x 3)) numbers)
;; (or true false)
;; (and true true)
;; (.contains word shot) invoke contains of java
;; do group events
;; cond group conditions
;; recur applies tail recursion that prevents invocation stacking of the methods (should be the last line of the function)