(ns tictactoe.logic.board
  (:require
    [tictactoe.logic.constants :as cst]))


;; TODO - investigate the possibility to have a truely empty board
;; TODO - full-board? would be a check of coordinates vs keys of map

(def empty-board
  "The empty board"
  (zipmap cst/coordinates (repeat :owner/none)))

(defn get-size
  "The size of the square board"
  [_]
  cst/board-size)

(def valid-coordinate?
  "Indicate if a coordinate is inside the board"
  (set cst/coordinates))

(defn convert-cell
  "Assign the cell [x y] to a new player"
  [board player x y]
  (if (valid-coordinate? [x y])
    (assoc board [x y] player)))

(defn has-no-owner?
  "Check whether the cell [x y] is empty"
  [board x y]
  (= (get board [x y]) :owner/none))

(defn full-board?
  "Verifies whether the board has any empty cell left"
  [board]
  (not-any? #{:owner/none} (vals board)))
