(ns ^{:author "gdallen"
      :doc "The second example of the strategy pattern uses multiple dispatch to replace the factory method to return the defense strategy"}
  self-defense-multi)

(defmulti get-defense-strategy (fn [a] (keyword (last (.split a " ")))))
(defmethod get-defense-strategy :banana [_] (fn []
  (println "Shoot the revolver")))
(defmethod get-defense-strategy :raspberry [_] (fn []
  (println "Pull the lever to release the 16 ton weight")))
(defmethod get-defense-strategy :default [_] (fn []
  (println "Run Away")))

(defn handle-attack [a]
  (let [defense (get-defense-strategy a)]
   (defense)))

(handle-attack "man with a banana")
(handle-attack "man with a raspberry")
(handle-attack "man with a pointed stick")
