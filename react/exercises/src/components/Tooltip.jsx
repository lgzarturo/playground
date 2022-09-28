import { useEffect, useRef, useState } from "react"

function Tooltip ({ tooltip, domRect }) {
    const [position, setPosition] = useState({ x: 0, y: 0 })
    const tooltipElement = useRef()
    useEffect(() => {
        let { width, height } = tooltipElement.current.getBoundingClientRect()
        let cords = {}
        if (domRect.y < height) {
            cords.y = domRect.y + height
        } else {
            cords.y = domRect.y - height
        }
        cords.x = domRect.x + (domRect.width / 2) - (width / 2)
        setPosition(cords)
    }, [domRect])
    return (
        <><span className="tooltip"
            ref={tooltipElement}
            style={{ left: position.x, top: position.y }}>{tooltip}</span></>
    )
}

export default Tooltip
