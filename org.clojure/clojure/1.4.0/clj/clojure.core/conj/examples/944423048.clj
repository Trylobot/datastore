;; maps and sets are treated differently
(conj {1 2} {3 4})
;; => {3 4, 1 2}   ; the contents of {3 4} are added to {1 2}

(conj #{1 2} #{3})
;; => #{1 2 #{3}}  ; the whole set #{3} is added to #{1 2}

(clojure.set/union #{1 2} #{3})
;; => #{1 2 3}  ; must use (clojure.set/union) to merge sets, not conj
