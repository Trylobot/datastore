(require '[clojure.string :as s])
;; => nil

;; Note: When replace-first or replace have a regex pattern as their
;; match argument, dollar sign ($) and backslash (\) characters in
;; the replacement string are treated specially.
;;
;; Example: first substring that the pattern matches is "fodder", with
;; (o+) matching "o" and (\S+) matching "dder".  Replacement string
;; says to replace the entire match "fodder" with $2, the string
;; matched by the second parenthesized group, "dder", followed by $1,
;; "o".
(s/replace "fabulous fodder foo food" #"f(o+)(\S+)" "$2$1")
;; => "fabulous ddero oo doo"

;; To avoid this special treatment of $ and \, you must escape them with
;; \.  Because it is in a Clojure string, to get one \ we must escape
;; *that* with its own \.
(s/replace "fabulous fodder foo food" #"f(o+)(\S+)" "\\$2\\$1")
;; => "fabulous $2$1 $2$1 $2$1"

;; To ensure the replacement is treated literally, call
;; java.util.regex.Matcher/quoteReplacement on it.  A shorter name
;; like re-qr can be handy.
(import '(java.util.regex Matcher))
;; => java.util.regex.Matcher

(defn re-qr [replacement]
  (Matcher/quoteReplacement replacement))
;; => #'user/re-qr

(s/replace "fabulous fodder foo food" #"f(o+)(\S+)" (re-qr "$2$1"))
;; => "fabulous $2$1 $2$1 $2$1"
