(ns ^{:author "gdallen"
      :doc "This is as close to a straight port of the java implmentation of the strategy pattern example as possible.  The concrete implementations of the defense interface are just functions here.  The factory method is essentially the same as in java, as is the context."}
  self-defense)

(defn revolver-defense []
  (println "Shoot the revolver"))

(defn sixteen-ton-weight-defense []
  (println "Pull the lever to release the 16 ton weight"))

(defn default-defense []
  (println "Run Away"))

(defn handle-attack [f]
  ; the defense strategies are functions so just call the function
  (f))

(defn get-defense-strategy [a]
  (cond
    (= a "man with a banana") revolver-defense
    (= a "man with a raspberry") sixteen-ton-weight-defense
    :else default-defense))

(defn handle-attack [a]
  (let [defense (get-defense-strategy a)]
   (defense)))

(handle-attack "man with a banana")
(handle-attack "man with a raspberry")
