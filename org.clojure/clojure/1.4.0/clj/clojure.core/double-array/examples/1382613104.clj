;; create a double array using double-array
;; and show it can be used with the standard Java functions
;; binarySearch and fill

 (def ds (double-array (range 3 20)))
;; => #'user/ds

(type ds)
;; => [D

(vec ds)
;; => [3.0 4.0 5.0 6.0 7.0 8.0 9.0 10.0 11.0 12.0 13.0 14.0 15.0 16.0 17.0 18.0 19.0]

(java.util.Arrays/binarySearch ds 10.0)
;; => 7

(java.util.Arrays/fill ds 3 8 99.0)
;; => nil

(vec ds)
;; => [3.0 4.0 5.0 99.0 99.0 99.0 99.0 99.0 11.0 12.0 13.0 14.0 15.0 16.0 17.0 18.0 19.0]
