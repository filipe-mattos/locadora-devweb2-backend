(ns locadora.intents)

(defmulti perform (fn [action _ctx] (first action)))

(defmethod perform :save [[_ domain entity] ctx]
  ((:save (get ctx domain)) entity))

(defmethod perform :find-all [[_ domain] ctx]
  ((:find-all (get ctx domain))))

(defmethod perform :find-by-id [[_ domain id] ctx]
  ((:find-by-id (get ctx domain)) id))

(defmethod perform :update [[_ domain id entity] ctx]
  ((:update (get ctx domain)) id entity))

(defmethod perform :remove [[_ domain id] ctx]
  ((:remove (get ctx domain)) id))