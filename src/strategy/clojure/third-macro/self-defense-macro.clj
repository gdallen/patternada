(ns  ^{:author "gdallen"
      :doc "The third example of the strategy pattern uses a macro to create the various multimethods that were defined in the second example. Because the macro is creating the defense strategies based on the input defense data, any new attack and defense pairs are simply added to the list and the code is created automatically"}
  self-defense-macro)


(defmulti get-defense-strategy (fn [a] (keyword (last (.split a " ")))))

(defmacro create-defense [attack message]
  (list 'defmethod 'get-defense-strategy `(keyword ~attack) '[_] 
     (list 'fn '[]
        (list 'println message))))


(def defenses '(("banana" "Shoot the revolver")
                ("raspberry" "Pull the lever to release the sixteen ton weight")
                ("peach" "release the crocodile")))

; Create multi methods for all the defenses in the table.
(doall (map (fn [[a b]] (create-defense a b)) defenses))

(defmethod get-defense-strategy :default [_] 
  (fn [] (println "Run Away")))

(defn handle-attack [a]
  (let [defense (get-defense-strategy a)]
   (defense)))

(handle-attack "man with a banana")
(handle-attack "man with a raspberry")
(handle-attack "man with a peach")
(handle-attack "man with a pointed stick")
