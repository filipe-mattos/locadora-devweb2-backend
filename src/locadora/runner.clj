(ns locadora.runner
  (:require [locadora.intents :as intents]))

(defn run [{:keys [actions]} ctx]
  (reduce (fn [_ a]
            (intents/perform a ctx)) ;; perform returns the last action result
          nil
          actions))